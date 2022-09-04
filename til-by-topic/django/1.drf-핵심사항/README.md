
- [ch0](#ch0)
  - [ch0 API URL vs 장고 권장 URL](#ch0-api-url-vs-장고-권장-url)
  - [장고 URL vs DRF URL](#장고-url-vs-drf-url)
  - [장고 serialize](#장고-serialize)
- [ch1](#ch1)

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