# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.


class ComputerClass(models.Model):
    response_person = models.CharField(max_length=100)
    number = models.IntegerField()


class Computer(models.Model):
    number = models.IntegerField()
    computer_class = models.ForeignKey(ComputerClass, on_delete=models.CASCADE)
    keyboard = models.CharField(max_length=50)