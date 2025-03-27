package com.mh.tselfa.quiz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    private String curriculumCode;
    private String curriculumName;
    private long largeChapterId;
    private String largeChapterName;
    private long mediumChapterId;
    private String mediumChapterName;
    private long smallChapterId;
    private String smallChapterName;
    private long subjectId;
    private String subjectName;
    private long topicChapterId;
    private String topicChapterName;
}
