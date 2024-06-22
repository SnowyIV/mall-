package com.geekaca.mall.geekmall.controller.admin;

import com.geekaca.mall.geekmall.common.Constants;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("/manage-api/v1")
public class AdminUploadController {
    @Autowired
    private StandardServletMultipartResolver standardServletMultipartResolver;

    /**
     * 图片上传
     */
//    @RequestMapping(value = "/upload/file", method = RequestMethod.POST)
//    @ApiOperation(value = "单图上传", notes = "file Name \"file\"")
//    public Result upload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws URISyntaxException {
//        String token = httpServletRequest.getHeader("token");
//        //获取上传的文件的原始的名字，不能直接用来保存，因为可能会导致冲突 比如你上传一个avatar.png ，别人也上传一个avatar.png
//        //目标：接收用户上传的图片，改名，而且不能冲突
//        String fileName = file.getOriginalFilename();
//        /**
//         * 取文件的扩展名
//         * avatar.png   jpg
//         */
//        //首先找到.在文件名字中最后一次出现的索引
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        //生成文件名称通用方法
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//        String curDtime = localDateTime.format(dft);
//        Random r = new Random();
//        StringBuilder tempName = new StringBuilder();
//        //为了生成随机的文件名字 + 扩展名
//        tempName.append(curDtime).append(r.nextInt(100)).append(suffixName);
//        String newFileName = tempName.toString();
//        File fileDirectory = new File(Constants.FILE_UPLOAD_DIC);
//        //创建文件
//        File destFile = new File(Constants.FILE_UPLOAD_DIC + newFileName);
//        try {
//            if (!fileDirectory.exists()) {
//                if (!fileDirectory.mkdir()) {
//                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
//                }
//            }
//            //把文件保存到指定位置
//            file.transferTo(destFile);
//            Result resultSuccess = ResultGenerator.genSuccessResult();
//            resultSuccess.setData(getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + newFileName);
//            return resultSuccess;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResultGenerator.genFailResult("文件上传失败");
//        }
//    }

    /**
     * 图片上传
     */
//    @RequestMapping(value = "/upload/files", method = RequestMethod.POST)
//    @ApiOperation(value = "多图上传", notes = "wangEditor图片上传")
//    public Result uploadV2(HttpServletRequest httpServletRequest) throws URISyntaxException {
//        List<MultipartFile> multipartFiles = new ArrayList<>(8);
//        if (standardServletMultipartResolver.isMultipart(httpServletRequest)) {
//            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) httpServletRequest;
//            Iterator<String> iter = multiRequest.getFileNames();
//            int total = 0;
//            while (iter.hasNext()) {
//                if (total > 5) {
//                    return ResultGenerator.genFailResult("最多上传5张图片");
//                }
//                total += 1;
//                MultipartFile file = multiRequest.getFile(iter.next());
//                multipartFiles.add(file);
//            }
//        }
//        if (CollectionUtils.isEmpty(multipartFiles)) {
//            return ResultGenerator.genFailResult("参数异常");
//        }
//        if (multipartFiles != null && multipartFiles.size() > 5) {
//            return ResultGenerator.genFailResult("最多上传5张图片");
//        }
//        List<String> fileNames = new ArrayList(multipartFiles.size());
//        for (int i = 0; i < multipartFiles.size(); i++) {
//            String fileName = multipartFiles.get(i).getOriginalFilename();
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            //生成文件名称通用方法
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//            Random r = new Random();
//            StringBuilder tempName = new StringBuilder();
//            tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
//            String newFileName = tempName.toString();
//            File fileDirectory = new File(Constants.FILE_UPLOAD_DIC);
//            //创建文件
//            File destFile = new File(Constants.FILE_UPLOAD_DIC + newFileName);
//            try {
//                if (!fileDirectory.exists()) {
//                    if (!fileDirectory.mkdir()) {
//                        throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
//                    }
//                }
//                multipartFiles.get(i).transferTo(destFile);
//                fileNames.add(getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + newFileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return ResultGenerator.genFailResult("文件上传失败");
//            }
//        }
//        Result resultSuccess = ResultGenerator.genSuccessResult();
//        resultSuccess.setData(fileNames);
//        return resultSuccess;
//    }

    public static URI getHost(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }
}
