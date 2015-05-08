package com.sds.icto.guestbook.test;

import java.util.List;

import com.sds.icto.guestbook.dao.GuestBookDao;
import com.sds.icto.guestbook.vo.GuestBookVo;

public class GuestBookTest {
	public static void main(String[] args) {
		try {
			// 0. Delete Test
//			 testDelete();

			// 1. Insert Test
//			 testInsert();

			// 2. FetchList Test
//			 testFetchList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void testFetchList() throws Exception {

		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.fetchList();

		for (GuestBookVo vo : list) {
			System.out.print(vo.getNo() + ":");
			System.out.print(vo.getName() + ":");
			System.out.print(vo.getPassword() + ":");
			System.out.print(vo.getMessage());
			System.out.print(vo.getRegdate());
			System.out.print("\n");
		}

	}

	public static void testInsert() throws Exception {

		GuestBookDao dao = new GuestBookDao();

		GuestBookVo vo = new GuestBookVo();
		vo.setName("ChaeHo");
		vo.setPassword("1234");
		vo.setMessage("msyluv@naver.com");

		vo = new GuestBookVo();
		vo.setName("ChaeHo2");
		vo.setPassword("12345");
		vo.setMessage("msyluv@naver.com2");

		dao.insert(vo);
	}
}
