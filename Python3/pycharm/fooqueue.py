# -*- coding:utf-8 -*-

from list import *

class FullError(Exception):
    pass

class EmptyError(Exception):
    pass

# 利用链表实现队列
class Queue(object):
    def __init__(self, maxsize = None):
        self.maxsize = maxsize
        self._item_linked_list = LinkedList()

    def __len__(self):
        return len(self._item_linked_list)

    def push(self, value):
        if self.maxsize is not None and len(self) >= self.maxsize:
            raise FullError('queue full')
        return self._item_linked_list.append(value)

    def pop(self):
        if len(self) <= 0:
            raise EmptyError('queue empty')
        return self._item_linked_list.popleft()


def test_queue():
    q = Queue()
    q.push(0)
    q.push(1)
    q.push(2)

    assert len(q) == 3

    assert q.pop() == 0
    assert q.pop() == 1
    assert q.pop() == 2

    import pytest
    with pytest.raises(EmptyError) as excinfo:
        q.pop()
    assert 'empty' in str(excinfo.value)


















