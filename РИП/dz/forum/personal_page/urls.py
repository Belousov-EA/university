from django.urls import path

from . import views

urlpatterns = [
    path('page', views.personal_page, name='page'),
    path('registration', views.registration, name='registration' ),
    path('auth', views.auth, name='auth'),
    path('logout', views.logout_view, name='logout'),
    path('', views.news, name='news')
]