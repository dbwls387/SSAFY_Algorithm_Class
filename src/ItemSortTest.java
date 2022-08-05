import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ItemSortTest {

	public static void main(String[] args) {
		List<Item> list = new ArrayList<>();
		list.add(new Item(3, "item3"));
		list.add(new Item(1, "item1"));
		list.add(new Item(2, "item23"));
		list.add(new Item(2, "item22"));

		list.forEach(item -> System.out.println(item)); // 등록된 순서대로 출력
		System.out.println();

		// 정렬
//		Collections.sort(list); // sort 아래에서 Comparable<Item> / compareTo
		Collections.sort(list,
				(o1, o2) -> o1.itemId == o2.itemId ? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId);

		list.forEach(item -> System.out.println(item)); // 등록된 순서대로 출력

		/////
//		List<String> list2 = new ArrayList<>();
//		list2.add("Hello");
//		list2.add("World");
//		list2.add("Ssafy");
//		
//		list2.forEach(s -> System.out.println(s));
//		
//		Collections.sort(list2);
//		
//		list2.forEach(s -> System.out.println(s));
	}

	static class Item {
//	static class Item implements Comparable<Item> {
		private int itemId;
		private String itemNm;

		public Item() {
		}

		public Item(int itemId, String itemNm) {
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public String getItemNm() {
			return itemNm;
		}

		public void setItemNm(String itemNm) {
			this.itemNm = itemNm;
		}

		// 아래의 코드로 Collections의 add, remove가 잘 될 것이다. 하지만, 정렬은 ??
		@Override
		public boolean equals(Object o) {
			if (o != null && o instanceof Item) {
				Item item = (Item) o;
				if (this.itemId == item.itemId && this.itemNm.equals(item.itemNm)) {
					return true;
				}
				return false;
			}

			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.itemId, this.itemNm);
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

//		@Override
//		public int compareTo(Item o) {
//			// Natural Ordering asc
////			return this.itemId - o.itemId;
//
//			// Natural Ordering 내림차순
////			return -(this.itemId - o.itemId);
//
//			// itemId 정렬 후 그 안에서 itemNm도 정렬
//			return this.itemId == o.itemId ? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;
//		}

	}

}
