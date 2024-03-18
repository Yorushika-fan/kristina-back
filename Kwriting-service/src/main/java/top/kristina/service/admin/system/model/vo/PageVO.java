package top.kristina.service.admin.system.model.vo;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Tag(name = "PageVo", description = "分页查询返回基本格式")
public class PageVO<T> {
    private Long total;
    private List<T> rows;
}
