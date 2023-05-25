package com.example.app.mapper;

import com.example.app.dto.ReplyDto;
import com.example.app.vo.ReplyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public void insert(ReplyDto replyDto);
    public List<ReplyVo> selectList(Long boardNumber);
    public ReplyVo select(Long replyNumber);
    public void update(ReplyDto replyDto);
    public void delete(Long replyNumber);
}














