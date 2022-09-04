from django.views.generic import TemplateView


class PostDetailTV(TemplateView):
    template_name = 'blog/post_detail.html'
