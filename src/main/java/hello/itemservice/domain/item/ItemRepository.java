package hello.itemservice.domain.item;

import hello.itemservice.domain.UpdateParamDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static, 동시에 디비에 접근하는 경우 concurrentHashMap 사용
    private static long sequence = 0L; //static, 원래는 atomicLong 사용

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);

         return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // Item updateparam 대신 updateParamDTO 만들어야 함 나중에 리팩토링
    public void update(Long itemId, UpdateParamDto updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void delete(Long itemId) {

        if(store.containsKey(itemId)) {
            store.remove(itemId);
        }
    }

    // 테스트용
    public void clearStore() {
        store.clear();
    }

}
