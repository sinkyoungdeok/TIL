from django.urls import path

from api import views


app_name = 'api'
urlpatterns = [
    path('post/list/', views.ApiPostLV.as_view(), name='post_list'),
    path('post/<int:pk>/', views.ApiPostDV.as_view(), name='post_detail'),
    path('catetag/', views.ApiCateTagView.as_view(), name='catetag_list'),
    path('like/<int:pk>/', views.ApiPostLikeDV.as_view(), name='post_like'),
    path('comment/create/', views.ApiCommentCV.as_view(), name='comment_create'),
]
