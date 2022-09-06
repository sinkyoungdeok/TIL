
- [ch0](#ch0)
  - [ch0 API URL vs 장고 권장 URL](#ch0-api-url-vs-장고-권장-url)
  - [장고 URL vs DRF URL](#장고-url-vs-drf-url)
  - [장고 serialize](#장고-serialize)
- [ch1](#ch1)
  - [DRF 공식 홈페이지](#drf-공식-홈페이지)
  - [DRF default mode](#drf-default-mode)
  - [DRF admin](#drf-admin)
  - [DRF login 기능](#drf-login-기능)
  - [url / view / serializer 구조 잡기](#url--view--serializer-구조-잡기)
  - [django app 추가 명령](#django-app-추가-명령)
  - [django router](#django-router)
  - [DefaultRouter vs SimpleRouter](#defaultrouter-vs-simplerouter)
  - [ViewSet](#viewset)
  - [Serialize](#serialize)
  - [Generic Views 활용](#generic-views-활용)
  - [PUT vs PATCH](#put-vs-patch)
  - [좋아요 API 구현](#좋아요-api-구현)
  - [python console에서 자동완성 기능 활용 방법](#python-console에서-자동완성-기능-활용-방법)
  - [직렬화, 역직렬화 과정](#직렬화-역직렬화-과정)

## ch0
- CBV (Class Based View)로 되어 있는 프로젝트
- ch1부터 DRF (Django Rest Framework)로 변경할 예정

### ch0 API URL vs 장고 권장 URL

ch0 API URL
| URL | Method | 뷰 이름 |
| --- | --- | --- |
| /api/post/list | GET | ApiPostLV (BaseListView) |
| /api/post/99 | GET | ApiPostDV (BaseDetailView) |
| /api/like/99/ | GET | ApiPostLikeDV | (BaseDetailView) |
| /api/catetag/ | GET | ApiCateTagView(View) |
| /api/comment/create | POST | ApiCommentCV (BaseCreateView) |


권장 URL: `/app이름/table이름/xxx/`
| URL | 동작 |
| --- | --- |
| /api/post/like | R |
| /api/post/99 | R |
| /api/post/create | C |
| /api/post/33/update | U |
| /api/post/99/delete | D |

- 현재: /api/like/99/ 
- 권장: /api/post/99/like


### 장고 URL vs DRF URL 
| URL | 동작 | Method | DRF URL | action |
| --- | --- | --- | --- | --- |
| /api/post/list | R | GET | /api/post/ | list |
| /api/post/99 | R | GET | /api/post/99/ | retrieve |
| /api/post/create | C | POST | /api/post/ | create | 
| /api/post/99/update | U | PUT | /api/post/99/ | update |
| /api/post/99/delete | D | DELETE | /api/post/99/ | delete 
| | | PATCH | /api/post/99 | partial_update


### 장고 serialize
- CBV에서는 
  - serialize를 직접 처리 한다.
  - DRF에서 Serialize사용이 어렵다고 느껴지면, 간단한 API들은 CBV로 만들어도 좋다. 
- DRF에서는 
  - ApiView나, GenericAPIView 를 상속받아서 처리한다 
  - Serializer를 사용하지 않는다.

## ch1
- project version
  - python: 3.10
  - django: 4.1
- pip installation
  - `pip install --upgrade pip setuptools wheel`
  - `pip install djangorestframework`

### DRF 공식 홈페이지 
- django-rest-framework.org

### DRF default mode
- browser에서의 요청: api
- client에서의 요청: json
- curl / httppie / postman / vue.js / react.js 에서의 요청: json

### DRF admin

```python
# mysite/settings.py

REST_FRAMEWORK = {
    # Use Django's standard `django.contrib.auth` permissions,
    # or allow read-only access for unauthenticated users.
    'DEFAULT_PERMISSION_CLASSES': [
        'rest_framework.permissions.DjangoModelPermissionsOrAnonReadOnly'
    ]
}
```

- 위 코드로 설정 하면, admin혹은 허용된 유저만 CUD에 접근 가능 하고, 익명 유저는 R만 접근 가능하다.
- 허용된 유저에 대한 설정은 로컬 DRF에서 admin으로 로그인하면 유저를 추가할 수 있다.

```python
# mysite/settings.py

REST_FRAMEWORK = {
}
```

- 위 코드로 설정하면, 익명 유저가 CRUD 모두 접근 가능 하다.

### DRF login 기능 
```python
urlpatterns = [
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]
```
- http://localhost:8000 화면에 로그인 버튼이 보이냐 안보이냐 차이이다.
- 이 코드를 주석 처리 하면, DRF에서 로그인 버튼이 보이지 않는다.

```python
urlpatterns = [
    path('admin/', admin.site.urls),
]
```
- api-auth 기능 대신, 로그인 기능이 필요할 시에 admin으로 직접 접근하는 방법.
- http://localhost:8000/admin 으로 접근하면 어드민 기능을 활용할 수 있다. 

### url / view / serializer 구조 잡기 
- MVT패턴 
  - sMuVT 
  - settings.py
  - Model
  - urls.py
  - Views.py
  - Template

### django app 추가 명령 
```shell
python manage.py startapp api2
```


### django router
- router 관련된 코드는 root (여기서는 /mysite)에서만 있어야 된다고 생각하는 사람들이 있긴 한데, 그렇지 않다. 하위 url에 넣어도 됨


### DefaultRouter vs SimpleRouter
```python
router = routers.DefaultRouter()
router.register(r'users', UserViewSet)
```

DefaultRouter와 SimpleRouter가 만들어주는 url  
- users/ GET(list), POST(create)
- users/pk/ GET(retrieve), PUT(update), DELETE(destroy), PATCH(partial_update)

DefaultRouter만 만들어주는 것들
- API Root (api2/)
- format suffix (users.json, users.api, users/99.json, users/99.api)

### ViewSet
```python
class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer
```

DRF 관련 문서: cdrf.co
CBV 관련 문서: ccbv.co.uk

- MIXINS 클래스를 모아서, GENERICS 클래스를 만들었다
- GENERICS 클래스를 모아서, VIEWSETS 클래스를 만들었다.
- View 클래스를 상속받아서 APIView 클래스를 만들고, APIView 클래스를 상속 받아서 GenericAPIView를 만들었다.
- GenericAPIView 에다가 CreateModelMixin(MIXINS) 을 추가해서 CreateAPIView(GENERICS)를 만들었다. 
- GenericAPIView 에다가 DestryModelMixin(MIXINS) 을 추가해서 DestryAPIView(GENERICS)를 만들었다.
  - Create: CreateAPIView (POST)
  - Read: ListAPIView, RetrieveAPIView (GET)
  - Update: UpdateAPIView (UPDATE, PATCH)
  - Delete: DestroyAPIView (DELETE)
- APIView들을 조합해서 새로운 APIView 들을 만든다.
  - ListCreateAPIView = ListAPIView + CreateAPIView
  - RetrieveUpdateDestroyAPIView =  RetrieveAPIView + UpdateAPIView + DestroyAPIView

ModelViewSet는 5개의 APIView로 만들었다. 
- Create: CreateAPIView (POST)
- Read: ListAPIView, RetrieveAPIView (GET)
- Update: UpdateAPIView (UPDATE, PATCH)
- Delete: DestroyAPIView (DELETE)


### Serialize
- 클라이언트에게 보낼 필드를 지정
- /api2/post/ 와 /api2/post/99/ 의 serialize 다르게 설정해주어야 한다.
  - PostViewSet하나로 처리가 가능하지만, 클라이언트의 다양한 요구사항을 맞추기 위해서는 복잡할 수 있고
  - ListApiView와 같이 개별로 처리하는게 편하다.


### Generic Views 활용 
- ViewSet으로 처리하게 되면, /api2/post/ 와 /api2/post/api/ 구현에 있어 serialize 설정이 복잡해질 수 있으므로, Generic Views를 활용해야 한다.
- `/api2/post/ (GET)` --> ListAPIView
- `/api2/post/99 (GET)` --> RetrieveAPIView
- `/api2/comment/ (POST)` --> CreateAPIView

Generic View의 로직 
1. db로부터 data를 읽어옴
2. data를 serialize
3. response


Serialize 차이
```python
class PostListAPIView(ListAPIView): # (many=True)
    queryset = Post.objects.all()
    serializer_class = PostSerializer


class PostRetrieveAPIView(RetrieveAPIView): # (many=False)
    queryset = Post.objects.all()
    serializer_class = PostSerializer
```

- 두개의 코드는 같지만, List와 Detail을 각각 구현 한 것이다.
- Serialize를 같은것을 사용하지만, Generic View의 차이 떄문에 `many=` 옵션이 추가되서 serialize가 달라진다.
  - many=True: 여러개 serialize
  - many=False: 한개만 serialize

결과
- 기존에 `viewsets.ModelViewSet`로 구현했을 때에는 serialize가 List API에는 적용되었지만, detail에는 적용이 안된것을 확인할 수 있었고
- ListAPIView, RetrieveAPIView 로 구현한 결과 List, Detail 모두 serialize가 잘 된 것을 확인할 수 있다. 

### PUT vs PATCH
- PUT은 필수 항목을 체크한다 (모델에서 blank 값의 여부에 따라 체크한다)
- PATCH는 필수 항목을 체크하지 않는다. (어느값이던 필수값이 아님)

```shell
python manage.py shell
from api2.serializers import *
PostListSerializer() # 이 명령어를 통해서 어떤 값이 필수 값인지 확인 할 수 있음
```


### 좋아요 API 구현 
- 좋아요는 Post의 like 정보만을 수정하는 것이지만, 이거는 직접적인 PUT 또는 UPDATE 메소드에서 구현된 것이 없다.
- 우리가 직접 커스터마이징을 해야되는데 어떻게 해야 할까?

```python
class PostLikeAPIView(UpdateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostLikeSerializer

    def update(self, request, *args, **kwargs):
        partial = kwargs.pop('partial', False)
        instance = self.get_object()
        data = {'like': instance.like + 1} # patch 명령이 오면 like+1
        serializer = self.get_serializer(instance, data=data, partial=partial)
        serializer.is_valid(raise_exception=True)
        self.perform_update(serializer)

        if getattr(instance, '_prefetched_objects_cache', None):
            instance._prefetched_objects_cache = {}

        return Response(data['like']) # response에 좋아요의 수만 보여주기
```
- 위와 같이 update 메서드를 https://www.cdrf.co/3.13/rest_framework.generics/UpdateAPIView.html 홈페이지에서 가져온 뒤, 수정을 하였다.

### python console에서 자동완성 기능 활용 방법 
```shell
python manage.py shell
import os, django
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'mysite.settings')
django.setup()
```


### 직렬화, 역직렬화 과정 
```python
# 직렬화
from rest_framework.renderers import JSONRenderer
c0 = Comment(...) # class 
sr = CommentSerializer(instance=c0) # dictionary
json0 = JSONRenderer().render(sr.data) # byte string (json 형태)
```

```python
# 역직렬화
from rest_framework.parsers import JSONParser
from io import BytesIO
json = ... # json data 
ddata0 = JSONParser().parse(BytesIO(json0)) # dictionary
dsr = CommentSerializer(data=ddata0) 
dsr.is_valid() # 유효성 검사 (필수)
instance = Comment(**dsr.validated_data) # class
instance.save() # db애 저장
```

- Serialize
  - read opeartion 사용 
  - GET
- DeSerialize
  - write operation 사용 
  - POST, UPDATE, DELETE, PATCH