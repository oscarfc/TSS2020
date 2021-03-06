/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pw.users;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author oscar.favero
 */
@ApplicationScoped
public class UserStore {

    private final Map<Long, User> users = new HashMap();

    public UserStore() {
    }

    @PostConstruct
    private void init() {
        Stream.of(new User(1L, "rossi", "rossipwd"), new User(2L, "verdi", "verdipwd"), new User(3L, "bianchi", "bianchipwd"))
                .forEach(v -> users.put(v.getId(), v));
    }

    Collection<User> all() {
        return users.values();
    }

    public User create(User u) {
        users.putIfAbsent(u.getId(), u);
        return users.get(u.getId());
    }

    public User update(User u) {
        System.out.println("update user " + u);
        return users.put(u.getId(), u);
    }

    public void delete(Long id) {
        System.out.println("delete user " + id);
        users.remove(id);
    }
}
