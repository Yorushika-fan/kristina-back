package top.kristina.service.admin.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.mapper.CommentMapper;
import top.kristina.service.admin.system.model.entity.Comment;
import top.kristina.service.admin.system.service.CommentService;
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{

}
