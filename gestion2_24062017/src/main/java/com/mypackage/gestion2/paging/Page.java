package com.mypackage.gestion2.paging;

import java.util.List;

public class Page<T> {

	private List<T> content;

	private Long total;

	private Integer pageNumber;

	private Integer pageSize;

	public Page() {
	}
	
	public Page(int page, List list, int intValue, int size) {
		this.pageNumber = page;
		this.content = list;
		this.total = new Long(intValue);
		this.pageSize = size;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getNumberOfElements() {
		return content.size();
	}

	public long getTotalElements() {
		return total;
	}

	public int getNumber() {
		return pageNumber;
	}

	public int getSize() {
		return pageSize;
	}

	public int getTotalPages() {
		return getSize() == 0 ? 0 : (int) Math.ceil((double) total
				/ (double) getSize());
	}

	public boolean hasPreviousPage() {
		return getNumber() > 0;
	}

	public boolean isFirstPage() {
		return !hasPreviousPage();
	}

	public boolean hasNextPage() {
		return ((getNumber() + 1) * getSize()) < total;
	}

	public boolean isLastPage() {
		return !hasNextPage();
	}

	public boolean hasContent() {
		return !content.isEmpty();
	}
}
