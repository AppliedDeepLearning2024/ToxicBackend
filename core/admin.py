from django.contrib import admin

from .models import Chemical, Endpoint, InferenceModel, Prediction

admin.site.register(Chemical)
admin.site.register(Endpoint)
admin.site.register(InferenceModel)
admin.site.register(Prediction)


# Register your models here.
