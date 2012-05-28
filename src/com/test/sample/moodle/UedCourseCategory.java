package com.test.sample.moodle;

import java.util.List;

public class UedCourseCategory {
	private int id;
	private String name;
	private String description;
	private int parent;
	private int sortOrder;
	private int courseCount;
	private boolean visible;
	private int depth;
	private List<UedCourseCategory> childs;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the parent
	 */
	public int getParent() {
		return parent;
	}
	
	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the sortOrder
	 */
	public int getSortOrder() {
		return sortOrder;
	}
	
	/**
	 * @param sortOrder
	 *            the sortOrder to set
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	/**
	 * @return the courseCount
	 */
	public int getCourseCount() {
		return courseCount;
	}
	
	/**
	 * @param courseCount
	 *            the courseCount to set
	 */
	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}
	
	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}
	
	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * @return the childs
	 */
	public List<UedCourseCategory> getChilds() {
		return childs;
	}
	
	/**
	 * @param childs
	 *            the childs to set
	 */
	public void setChilds(List<UedCourseCategory> childs) {
		this.childs = childs;
	}
	
}
