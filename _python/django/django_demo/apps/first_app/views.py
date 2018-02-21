from django.shortcuts import render, HttpResponse

# Create your views here.
def index(request):
    return HttpResponse('made it to the index method')