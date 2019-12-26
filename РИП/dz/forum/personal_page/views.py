from django.shortcuts import render
from django.contrib.auth.models import User
from django import forms
from django.http import HttpResponse, HttpResponseRedirect
from django.contrib.auth import login, authenticate
from django.contrib.auth import logout
from .models import New, Comment


def is_auth(func):
    def new_func(request):
        if request.user.is_authenticated:
            return func(request)
        return HttpResponseRedirect('auth')
    return new_func


class AuthForm(forms.Form):
   username = forms.CharField(label='Логин')
   password = forms.CharField(widget=forms.PasswordInput, label='Пароль')


def auth(request):
    was_wrong=0
    if request.method == 'POST':
        form = AuthForm(request.POST)
        if form.is_valid():
            cd = form.cleaned_data
            user = authenticate(username=cd['username'], password=cd['password'])
            if user is not None:
                login(request, user)
                return HttpResponseRedirect('/')
            was_wrong = 1
            context = {'form': form,
                       'was_wrong': was_wrong}
            return render(request, 'personal_page/auth.html', context)
    else:
        form = AuthForm()
    context = {'form' : form,
               'was_wrong' : was_wrong}
    return render(request, 'personal_page/auth.html', context)


class UserInfo(forms.Form):
    login = forms.CharField(min_length=1, label='Логин')
    password = forms.CharField(min_length=1, widget=forms.PasswordInput, label='Старый пароль')
    new_password = forms.CharField(min_length=6, widget=forms.PasswordInput, label='Новый пароль')
    new_password2 = forms.CharField(min_length=6, widget=forms.PasswordInput, label='Повторите пароль')


# Create your views here.
@is_auth
def personal_page(request):
    changed = 0
    form = UserInfo
    if request.method == 'POST':
        form = UserInfo(request.POST)
        if form.is_valid():
            cd = form.cleaned_data
            user = authenticate(username=request.user, password=cd['password'])
            if user is not None:
                user.password = cd['new_password']
                user.save()
                changed = 1
    context = {'name': request.user, 'form':form, 'changed':changed}
    return render(request, 'personal_page/page.html', context)

class RegistrationForm(forms.Form):
    username = forms.CharField(min_length=5, label='Логин')
    password = forms.CharField(min_length=6, widget=forms.PasswordInput, label='Пароль')
    password2 = forms.CharField(min_length=6, widget=forms.PasswordInput, label='Повторите ввод')


def registration(request):
    if request.method == 'POST':
        form = RegistrationForm(request.POST)
        if form.is_valid():
            cd = form.cleaned_data
            user = User.objects.create_user(username=cd['username'], password=cd['password'])
            user.save()
            return HttpResponseRedirect('auth')
    else:
        form = RegistrationForm()

    return render(request, 'personal_page/registration.html', {'form': form})


@is_auth
def logout_view(request):
    logout(request)
    return render(request, 'personal_page/logout.html', {})



@is_auth
def news(request):
    news_obj = New.objects.all().order_by('-id')
    if request.method == 'POST':
        for i in range(1, len(news_obj)+1):
            ask = 'add-comment'+str(i)
            if request.POST.get(ask) is not None:
                text = request.POST.get(ask)
                new = New.objects.all().filter(id=i)[0]
                comment = Comment(text=text, new=new, user=request.user)
                comment.save()
        print(request.POST)

    news=[]
    for new_obj in news_obj:
        comments = Comment.objects.all().filter(new=new_obj).order_by('-id')
        comments_list = []
        for comment in comments:
            comment_dict = {'date': comment.date, 'text': comment.text, 'user':comment.user}
            comments_list.append(comment_dict)
        new = {'text': new_obj.text, 'date':new_obj.date, 'comments': comments_list,
               'id': new_obj.id}
        news.append(new)
    context = {'news': news}
    return render(request, 'personal_page/news.html', context)






