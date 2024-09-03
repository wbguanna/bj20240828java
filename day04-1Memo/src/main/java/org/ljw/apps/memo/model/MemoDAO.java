package org.ljw.apps.memo.model;

import java.util.ArrayList;
import java.util.List;

public class MemoDAO {
	private List<Memo> memos;
	private int nextId;
	
	public MemoDAO() {
		memos = new ArrayList<Memo>();
		nextId = 1;
	}
	
	//crud
	public Memo getMemo(int startIdx) {
		return memos.get(startIdx);
	}
	
	public ArrayList<Memo> getMemo(int startIdx, int endIdx) {
		ArrayList<Memo> result = new ArrayList<Memo>();
		for (; startIdx < endIdx; startIdx++) {
			result.add(memos.get(startIdx));
		}
		return result;
	}
	
	public void addMemo(Memo newMemmo) {
		memos.add(newMemmo);
		nextId += 1;
	}
	public boolean updateMemo(Memo memo) {
		for (Memo e : memos) {
			if (e.getId() == memo.getId()) {
				e.setContent(memo.getContent());
				e.setTitle(memo.getTitle());
				
				return true;
			}
		}
		return false;
	}
	public boolean deleteMemo(int id) {
//		memos.forEach((e)->{if(memo.equals(e)) memos.remove(e);});

		for (Memo e : memos) {
//			if (e.getId() == memo.getId()) {
			if (e.getId() == id) {
				memos.remove(e);
				return true;
			}
		}
		return false;
	}

	public Memo getMemoById(int id) {
		// TODO Auto-generated method stub
		for(Memo m : memos) {
			if(m.getId() == id) {
				return m;
			}
		}
		
		return null;
	}

	public List<Memo> getAllMemos() {
		// TODO Auto-generated method stub
		return memos;
	}
	
}
