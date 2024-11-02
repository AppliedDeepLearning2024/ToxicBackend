from django.urls import path

from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("inferencemodels", views.getModels, name="inferencemodels"),
]