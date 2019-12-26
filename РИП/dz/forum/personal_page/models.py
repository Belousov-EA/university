from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class my_user(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    name = models.CharField(max_length=200)
    second_name = models.CharField(max_length=200)

class New(models.Model):
    text = models.CharField(max_length=1500)
    date = models.DateField(auto_now_add=True)

    def __str__(self):
        return '{0}'.format(self.text[:20])


class Comment(models.Model):
    text = models.CharField(max_length=1000)
    date = models.DateField(auto_now_add=True)
    new = models.ForeignKey(New, on_delete=models.CASCADE)
    user = models.CharField(max_length=100)

    def __str__(self):
        return '{0}'.format(self.text[:20])