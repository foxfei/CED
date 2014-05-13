package com.skyteam.ced.dao.impl.hibernate3.base;

import common.dao.GenericDao;

public class _RootDao {
	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	private GenericDao genericDao;
}
