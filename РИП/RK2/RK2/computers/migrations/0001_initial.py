# -*- coding: utf-8 -*-
# Generated by Django 1.11.27 on 2019-12-22 20:05
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Computer',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('number', models.IntegerField()),
                ('keyboard', models.CharField(max_length=50)),
            ],
        ),
        migrations.CreateModel(
            name='ComputerClass',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('response_person', models.CharField(max_length=100)),
                ('number', models.IntegerField()),
            ],
        ),
        migrations.AddField(
            model_name='computer',
            name='computer_class',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='computers.ComputerClass'),
        ),
    ]
