package com.f2f.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/store/img")
//public class ImagePathController {
//
//    /*
//    stf : پوشه ایی که کارکنان تصاویر کالا را بارگزاری کرده اند
//    user: پوشه ایی که کاربران تصاویر کالا را بارگزاری کرده اند
//     */
//    //type : small,medium,large,detail,original,additional,detail,card
//    //productId/user/userId/type/
//    //productId/stf/type/
//
//    private final Path uploadDir ;
//
//    public ImagePathController(@Value("${public.image.dir}") String uploadDir
//                               ) {
//        this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
//    }
//
//    private Path secureResolve(Path folder){
//        Path normalized = folder.normalize();
//        if(!normalized.startsWith(uploadDir)){
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"access denied");
//        }
//        return normalized;
//
//    }
//
//    private List<String> getRelativeImagePaths(Path folder, String urlPrefix) {
//        try (Stream<Path> stream = Files.list(secureResolve(folder))) {
//            return stream
//                    .filter(Files::isRegularFile)
//                    .map(path -> urlPrefix + "/" + path.getFileName().toString())
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            //log.error("Error reading image paths: {}", e.getMessage());
//            return Collections.emptyList();
//        }
//    }
//
//
//    /*
//    تصویر کالا برای مشاهده کاربر به کلاینت برگردانده می شود
//    هنگامی که کاربر در صفحه اصلی کالا را می بیند
//     */
//    @GetMapping("/{productId}/stf/card/")
//    public List<String> getStaffImageCards(@PathVariable("productId") String productId) {
//        Path path = uploadDir.resolve(productId).resolve("stf").resolve("card");
//        return getRelativeImagePaths(path, "/images/"+ productId + "/stf/card/");
//    }
//
//    /*
//    لیستی از تصاویر مر بوط به کالا برای صفحه اصلی کالا به کلاینت برگردانده می شود
//     */
//    @GetMapping("/{productId}/stf/detail/")
//    public List<String> getStaffProductDetailImages(@PathVariable("productId") String productId) {
//        Path folderPath = uploadDir.resolve(productId).resolve("stf").resolve("detail");
//        return getRelativeImagePaths(folderPath, "/images/" + productId + "/stf/detail");
//    }
//
//    /*
//    تصاوبر بارگذاری شده توسط یک مشتری خاص که در پوشه medium قرار دارد برگردانده می شود
//     */
//    @GetMapping("/{productId}/user/{userId}/medium")
//    public List<String> getUserProductImages(@PathVariable("productId") String productId,
//                                           @PathVariable("userId") String userId) {
//        Path folderPath = uploadDir.resolve(productId).resolve("user").resolve(userId).resolve("medium");
//        return getRelativeImagePaths(folderPath, "/images/" + productId + "/user/" + userId + "/medium");
//    }
//
//    /*
//    لیست تصاویر یک کالا با توجه به نوع ان که توسط کارکنان بارگزاری شده است برگردانده می شود.
//     */
//    @GetMapping("/{productId}/stf/{typeImg}/")
//    public List<String> getStaffProductImageTypes(@PathVariable("productId") String productId,
//                                           @PathVariable("typeImg") String typeImg) {
//
//        Path folderPath = uploadDir.resolve(productId).resolve("stf").resolve(typeImg);
//        return getRelativeImagePaths(folderPath, "/images/" + productId + "/stf/" + typeImg);
//
//    }
//
//}

public class ImagePathController {
}