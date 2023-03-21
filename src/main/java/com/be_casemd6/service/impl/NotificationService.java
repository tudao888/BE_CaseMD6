package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import com.be_casemd6.model.Notification;
import com.be_casemd6.model.dto.NotificationDTO;
import com.be_casemd6.repo.INotificationRepo;
import com.be_casemd6.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class NotificationService implements INotificationService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProviderService providerService;
    @Autowired
    private INotificationRepo notificationRepo;

    @Override
    public List<NotificationDTO> showNotification(int account_id) {
        return null;
    }
//    @Override
//    public List<NotificationDTO> showNotification(int account_id) {
//        return
//    }

//    public NotificationDTO createNewNotification(int idUser, int idProvider) {
//        Account account = accountService.findAccountById(idUser);
//        Provider provider = providerService.findProviderById(idProvider);
//        Notification notification = new Notification();
//        notification.setAccount(provider.getAccount());
//        notification.setAccountSend(account);
//        notification.setDate(LocalDate.now());
//        notification.setStatusNotification(1);
//        notificationRepo.save(notification);
//        NotificationDTO notificationDTO = new NotificationDTO(notification.getId(), notification.getAccountSend().getId(), notification.getAccountSend().getFullName(), notification.getAccountSend().getAvatar(), notification.getDate(),  notification.getStatusNotification(), notification.getId_answer());
//        return notificationDTO;
//    }
}
