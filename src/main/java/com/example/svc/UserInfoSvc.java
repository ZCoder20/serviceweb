package com.example.svc;

import com.example.common.util.ByteUtil;
import com.example.repo.UserInfoRepo;
import com.example.repo.domain.InlineRespone201;
import com.example.repo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.util.Date;

@Component
public class UserInfoSvc {
    private static final String UPLOAD_FOLDER = "/Users/mahimatripathi/Downloads/postgres/src/main/resources/image/"; // Replace with the actual upload folder path
    private final UserInfoRepo userInfoRepo;
    @Autowired
    public UserInfoSvc(UserInfoRepo userInfoRepo){
        this.userInfoRepo = userInfoRepo;
    }
    /*public InlineRespone201 saveUserInfo(UserInfo userinfo,MultipartFile imageFile) throws IOException {

        // To save the image in upload folder
        String fileName = imageFile.getOriginalFilename();
        String filePath = UPLOAD_FOLDER + fileName;
        byte[] imageBytes = imageFile.getBytes();
        Path path = Paths.get(filePath);
        Files.write(path, imageBytes);
        InputStream inputStream = imageFile.getInputStream();
        Path path1 = path.resolve(filePath);
        Files.copy(inputStream, path1, StandardCopyOption.REPLACE_EXISTING);

        //To save in DB
      UserInfo userInfo = userInfoRepo.save(userinfo);
        return new InlineRespone201().postingIdentifier(userinfo.getUserId());
    }

    public UserInfo getImage(int userId) throws IOException, ClassNotFoundException {
       UserInfo userResponse = userInfoRepo.getAllByUserId(userId);
       System.out.println(userResponse.getPhotoID());
       ByteUtil.convertToObj(userResponse.getPhotoID());
        System.out.println(ByteUtil.convertToObj(userResponse.getPhotoID()));
       return userResponse;
    }
*/


   /* public InlineRespone201 saveUserInfo(int userId, String firstName, String lastName, String middleName, String dob,
                                         String streetAddress1, String city, String state,String country,
                                         int idNumber, String idType, String issueCountry,
                                         String citizenCountry, String categoryPreference,
                                         boolean isCompany, MultipartFile imageFile) throws IOException {
        // Save the image file to the upload folder
        String fileName = imageFile.getOriginalFilename();
        String filePath = UPLOAD_FOLDER + fileName;
        byte[] imageBytes =imageFile.getBytes();
        Path path = Paths.get(filePath);
        //byte[] imageBytes = imageFile.getBytes();

       // Files.write(path, imageBytes);


        InputStream inputStream1 = imageFile.getInputStream();
            Path path1 = path.resolve(filePath);
            Files.copy(inputStream1, path1, StandardCopyOption.REPLACE_EXISTING);


        // Create a new person entity with the details
        ByteBuffer photBuffer = ByteUtil.toByteBuffer(null);
        UserInfo userInfo = UserInfo.builder().userId(userId).firstName(firstName).middleName("").lastName(lastName).dob(new Date()).
                streetAddress1(streetAddress1).city(city).state(state).country(country).
                issueCountry(issueCountry).idNumber(idNumber).idType(idType).
                photoID(photBuffer.array()).citizenCountry(citizenCountry).
                isCompany(true).isSeller(true).categoryPreference(categoryPreference).build();

        UserInfo userInfo1 = userInfoRepo.save(userInfo);
        return new InlineRespone201().postingIdentifier(userInfo1.getUserId());

    }*/

    public InlineRespone201 saveUserInfo(int userId, String isSeller, String isCompany,
                                         String firstName, String middleName, String lastName, String dob,
                                         String streetAddress1, String city, String state, String country,
                                         int idNumber, String idType, String issueCountry,
                                         String citizenCountry, String categoryPreference,
                                         String emailId, int phoneNum1, String countryOfBusiness,
                                         String verificationLink, MultipartFile imageFile) throws IOException {

        // Save the image file to the upload folder
        String fileName = imageFile.getOriginalFilename();
        String filePath = UPLOAD_FOLDER + fileName;
        byte[] imageBytes =imageFile.getBytes();
        Path path = Paths.get(filePath);
        //byte[] imageBytes = imageFile.getBytes();

        // Files.write(path, imageBytes);


        InputStream inputStream1 = imageFile.getInputStream();
        Path path1 = path.resolve(filePath);
        Files.copy(inputStream1, path1, StandardCopyOption.REPLACE_EXISTING);


        // Create a new person entity with the details
        ByteBuffer photBuffer = ByteUtil.toByteBuffer(null);

        UserInfo userInfo = UserInfo.builder().isSeller(true).isCompany(true)
                .userId(userId).firstName(firstName).middleName(middleName).lastName(lastName).dob(new Date())
                .streetAddress1(streetAddress1).city(city).state(state).country(country)
                .idNumber(idNumber).idType(idType).issueCountry(issueCountry)
                .photoID(photBuffer.array()).citizenCountry(citizenCountry)
                .categoryPreference(categoryPreference).emailId(emailId)
                .phoneNum1(phoneNum1).countryOfBusiness(countryOfBusiness)
                .verificationLink(verificationLink).build();

        UserInfo userInfo1 = userInfoRepo.save(userInfo);
        return new InlineRespone201().postingIdentifier(userInfo1.getUserId());


    }



  /*  public ResponseEntity<byte[]> getImage() throws IOException {

        var imgFile = new ClassPathResource("/Users/mahimatripathi/Downloads/postgres/src/main/resources/image/testVideo.mov");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);



            try {
                Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
                Resource resource = new UrlResource(filePath.toUri());
                if (resource.exists()) {
                    return resource;
                } else {
                    throw new FileNotFoundException("File not found " + fileName);
                }
            } catch (MalformedURLException ex) {
                throw new FileNotFoundException("File not found " + fileName, ex);

        }
    }*/
}
