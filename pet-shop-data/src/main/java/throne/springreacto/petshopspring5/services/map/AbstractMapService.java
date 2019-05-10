package throne.springreacto.petshopspring5.services.map;

import throne.springreacto.petshopspring5.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {
    Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(nextId());
            }
            map.put(object.getId(), object);
        }else {
            throw new RuntimeException("Object can not be null");
        }
        return object;
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    void deleteById(ID id){
        map.remove(id);
    }

    private Long nextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet());
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
