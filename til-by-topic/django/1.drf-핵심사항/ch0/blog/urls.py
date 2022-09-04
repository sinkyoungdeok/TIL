from django.urls import path

from blog import views


app_name = 'blog'
urlpatterns = [
    # /blog/post/99/
    path('post/<int:pk>/', views.PostDetailTV.as_view(), name='post_detail'),
]
