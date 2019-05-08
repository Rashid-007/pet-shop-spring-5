package throne.springreacto.petshopspring5.services;

import throne.springreacto.petshopspring5.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String name);
}
