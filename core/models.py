from django.db import models

class Chemical(models.Model):
    smile = models.TextField()
    def __str__(self):
        return self.smile

class Endpoint(models.Model):
    name = models.CharField(max_length=255)
    
    def __str__(self):
        return self.name

class InferenceModel(models.Model):
    name = models.CharField(max_length=255)

    def __str__(self):
        return self.name

class Prediction(models.Model):
    chemical = models.ForeignKey(Chemical, on_delete=models.CASCADE)
    model = models.ForeignKey(InferenceModel, on_delete=models.CASCADE)
    endpoint = models.ForeignKey(Endpoint, on_delete=models.CASCADE)
    prediction = models.FloatField()
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"{self.chemical=},{self.model=},{self.endpoint=},{self.prediction=}"
