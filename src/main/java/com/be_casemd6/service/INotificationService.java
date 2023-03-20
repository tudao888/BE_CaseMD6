package com.be_casemd6.service;

import com.be_casemd6.model.Notification;
import com.be_casemd6.model.dto.NotificationDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotificationService {
    List<NotificationDTO> showNotification(int account_id);
}
