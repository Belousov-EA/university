# Generated by Django 3.0.1 on 2019-12-25 23:16

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('personal_page', '0002_comment_new'),
    ]

    operations = [
        migrations.AddField(
            model_name='comment',
            name='user',
            field=models.CharField(default='', max_length=100),
            preserve_default=False,
        ),
    ]
