from django.db import models

# Create your models here.
class ClassesShedule(models.Model):
    subject = models.CharField(max_length=200)
    num = models.IntegerField(null=True)
    day = models.DateField()

    def __str__(self):
        return self.subject

