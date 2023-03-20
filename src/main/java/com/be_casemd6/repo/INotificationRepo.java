package com.be_casemd6.repo;

import com.be_casemd6.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotificationRepo extends JpaRepository<Notification, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM notification WHERE notification.account_id =:account_id ORDER BY date DESC")
    List<Notification> showNotification(@Param("account_id") int account_id);

}
