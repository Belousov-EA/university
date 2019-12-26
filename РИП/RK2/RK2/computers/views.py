# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render
from django.http import HttpResponse
from .models import Computer, ComputerClass
from django.http import Http404

# Create your views here.
def computers_view(request):
    computer_class_list = ComputerClass.objects.order_by('number')
    print (computer_class_list)
    output = []
    for computer_class in computer_class_list:
        computer_list = Computer.objects.filter(computer_class=computer_class)
        print( computer_list)
        for computer in computer_list:
            string ={'computer_class_number':computer_class.number,
                     'computer_class_person':computer_class.response_person,
                     'computer_number':computer.number,
                     'keyboard':computer.keyboard}
            output.append(string)
    if output is None:
        raise Http404("Computers does not exist")
    context = {'computer_list' : output}
    return render(request, 'index.html', context)