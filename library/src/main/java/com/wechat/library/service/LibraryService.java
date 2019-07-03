package com.wechat.library.service;

import com.wechat.library.domain.Book;
import com.wechat.library.domain.DebitList;
import org.springframework.data.domain.Page;

public interface LibraryService {

	Page<Book> search(String keyword, int pageNumber);

	void add(DebitList list, String bookId);

	void remove(DebitList list, String id);

}
