def obj_to_post(obj, flag=True):
    """
    obj 의 각 속성을 serialize 해서, dict 로 변환한다.
    serialize: python object --> (기본 타입) int, float, str
    :param obj:
    :param flag: True (모두 보냄, /api/post/99/ 용), False (일부 보냄, /api/post/list/ 용)
    :return:
    """
    post = dict(vars(obj))

    if obj.category:
        post['category'] = obj.category.name
    else:
        post['category'] = 'NoCategory'

    if obj.tags:
        post['tags'] = [t.name for t in obj.tags.all()]
    else:
        post['tags'] = []

    if obj.image:
        post['image'] = obj.image.url
    else:
        post['image'] = 'https://via.placeholder.com/900x300/'

    if obj.update_dt:
        post['update_dt'] = obj.update_dt.strftime('%Y-%m-%d %H:%M:%S')
    else:
        post['update_dt'] = '9999-12-31 00:00:00'

    del post['_state'], post['category_id'], post['create_dt'], post['_prefetched_objects_cache']
    if not flag:
        del post['tags'], post['update_dt'], post['description'], post['content']

    return post


def prev_next_post(obj):
    try:
        prevObj = obj.get_previous_by_update_dt()
        prevDict = {
            'id': prevObj.id,
            'title': prevObj.title,
        }
    except obj.DoesNotExist:
        prevDict = {}

    try:
        nextObj = obj.get_next_by_update_dt()
        nextDict = {
            'id': nextObj.id,
            'title': nextObj.title,
        }
    except obj.DoesNotExist:
        nextDict = {}

    return prevDict, nextDict


def obj_to_comment(obj):
    """ comment 객체를 serialize 한다. """
    comment = dict(vars(obj))

    if obj.update_dt:
        comment['update_dt'] = obj.update_dt.strftime('%Y-%m-%d %H:%M:%S')
    else:
        comment['update_dt'] = '9999-12-31 00:00:00'

    del comment['_state'], comment['post_id'], comment['create_dt']

    return comment
