from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
import json


from django.http import HttpResponse, JsonResponse
from django.core import serializers
from .models import InferenceModel, Chemical, Prediction, Endpoint

def convet_all_to_dict(xs: list):
    return [
        el.to_dict()
        for el in xs
    ]

@csrf_exempt
def getModels(request):
    if request.method == "GET":
        qs = InferenceModel.objects.all()
        qs = convet_all_to_dict(qs)
        return JsonResponse(qs, safe=False)
    
    if request.method == "POST":
        data = json.loads(request.body)
        res = InferenceModel.objects.create(
            name=data.get("name")
        )
        return JsonResponse(res.to_dict(), safe=False)


def index(request):
    return HttpResponse("Hello, world. You're at the polls index.")
