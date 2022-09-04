from django.urls import path, include
from rest_framework import routers

from api2.views import UserViewSet

router = routers.DefaultRouter()
router.register(r'users', UserViewSet)

urlpatterns = [
    path('api2/', include('api2.urls')),
]