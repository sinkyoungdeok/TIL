
- [챕터별 간략 설명](#챕터별-간략-설명)
  - [ch0](#ch0)
    - [ch0 API URL vs 장고 권장 URL](#ch0-api-url-vs-장고-권장-url)
    - [장고 URL vs DRF URL](#장고-url-vs-drf-url)

# 챕터별 간략 설명

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

