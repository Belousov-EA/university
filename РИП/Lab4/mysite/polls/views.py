from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader
from .models import ClassesShedule
from datetime import *

# Create your views here.
def index(request):
    d = datetime.now()
    months = ['января', "февраля", "марта", "апреля", "мая", "июня", "июля", "августа",
              "сентября", "ноября", "декабря"]
    classes = ClassesShedule.objects.all().filter(day =datetime.today()).order_by('num')
    context = {'day': str(d.day), 'month': months[d.month - 2], 'year': str(d.year),
            'hours': d.hour, 'minutes': d.minute,
            'classes': classes   }
    return render(request, 'polls/lab4.html', context= context)

def shedule(request):
    d1 = datetime.today()
    d2 = d1+timedelta(days=1)
    d3 = d2+timedelta(days=1)
    d4 = d3+timedelta(days=1)
    d5 = d4+timedelta(days=1)
    classes1 = ClassesShedule.objects.all().filter(day=d1).order_by('num')
    classes2 = ClassesShedule.objects.all().filter(day=d2).order_by('num')
    classes3 = ClassesShedule.objects.all().filter(day=d3).order_by('num')
    classes4 = ClassesShedule.objects.all().filter(day=d4).order_by('num')
    classes5 = ClassesShedule.objects.all().filter(day=d5).order_by('num')
    classes = [classes1, classes2, classes3, classes4, classes5]
    context = {'classes': classes}
    return render(request, 'polls/shedule.html', context=context)