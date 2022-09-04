
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
