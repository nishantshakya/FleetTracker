package com.shakya.repository.specs;

import com.shakya.entity.Alert;
import com.shakya.entity.Reading;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReadingSpecification implements Specification<Reading> {

    private List<SearchCriteria> list;

    public ReadingSpecification() {
        this.list = new ArrayList<>();
    }

    @Override
    public Specification<Reading> and(Specification<Reading> other) {
        return null;
    }

    @Override
    public Specification<Reading> or(Specification<Reading> other) {
        return null;
    }

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Reading> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : list) {
             if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            }else if (criteria.getKey().equals("priority")){
                 Join<Reading, Alert> readingAlertJoin = root.join("alerts");
                 predicates.add(builder.equal(readingAlertJoin.get("priority"), criteria.getValue()));
             }
             else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
