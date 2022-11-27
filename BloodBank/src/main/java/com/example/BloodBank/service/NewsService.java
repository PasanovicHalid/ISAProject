package com.example.BloodBank.service;

import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.News;
import com.example.BloodBank.repository.NewsRepository;
import com.example.BloodBank.service.service_interface.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsService implements INewsService {
    private final NewsRepository newsRepository;
    private final RabbitMQSender rabbitMQSender;
    @Autowired
    public NewsService(NewsRepository newsRepository,
                       RabbitMQSender rabbitMQSender) {
        this.newsRepository = newsRepository;
        this.rabbitMQSender = rabbitMQSender;
    }
    @Override
    public News Create(News entity) throws Exception {
        return newsRepository.save(entity);
    }

    @Override
    public News Read(Long id) throws Exception {
        Optional<News> news = newsRepository.findById(id);
        if(news.isPresent()){
            return news.get();
        } else  {
            throw new EntityDoesntExistException(id);
        }
    }

    @Override
    public News Update(News entity) throws Exception {
        return null;
    }

    @Override
    public void Delete(News entity) throws Exception {
        newsRepository.delete(entity);
    }

    @Override
    public Iterable<News> GetAll() throws Exception {
        return newsRepository.findAll();
    }
    public News CreateAndSendNews(News entity) throws Exception {
        rabbitMQSender.sendNews(entity);
        return Create(entity);
    }
}
