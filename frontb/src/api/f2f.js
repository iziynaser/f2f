import qs from 'qs';

const CLIENT_ID='spring-security-oauth2-read-write-client' ;
//const CLIENT_SECRET='spring-security-oauth2-read-write-client-password1234';

// gatewya
const ROOT_URL='http://localhost:8085' ;
//const ROOT_URL='http://localhost:8080' ;
//const ROOT_URL='http://localhost:8080' ;

export default{

    login(){
            const queryString = {
                grant_type:'password' ,
                username:'admin' ,
                password:'admin1234' ,
                client_Id : CLIENT_ID,
                responseType: 'token'
            };
            window.location = `${ROOT_URL}/oauth/token?${qs.stringify(queryString)}`
    },

    url(address){
        return `${ROOT_URL}/${qs.stringify(address)}`
    }    
};