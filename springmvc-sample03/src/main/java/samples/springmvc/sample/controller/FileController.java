package samples.springmvc.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import samples.springmvc.sample.vo.ResultVO;

import java.util.UUID;

/**
 * @Author qianqian.sun
 * @Date 2017/5/27
 * 描述：
 */
@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("/upload")
    public ResultVO page(@RequestParam("file") MultipartFile file) {
        logger.info("文件上传,file:{}", file.getOriginalFilename());
        // 分配文件ID
        ResultVO resultVO = new ResultVO(true);
        resultVO.setData(UUID.randomUUID().toString());
        return resultVO;
    }

    @RequestMapping("/submit")
    public ResultVO page(String fileId) {
        logger.info("文件提交,file:{}", fileId);
        // 分配文件ID
        ResultVO resultVO = new ResultVO(true);
        resultVO.setMsg("操作完成");
        return resultVO;
    }

}
