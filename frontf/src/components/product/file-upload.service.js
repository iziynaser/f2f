import axiosInstance from '@/api/axiosInstance';

const BASE_URL = '/storage/upload-multiple-files';
//const BASE_URL = '/storage/upload-file?access_token=';



// function upload(formData) {
    
//     console.log('upload is called......')
//     const url = `${BASE_URL}/`;
//     return axios.post(url, formData)
//         // get data
//         .then(x => x.data)
//         // add url field
//         .then(x => x.map(img => Object.assign({},
//             img, { url: `${BASE_URL}/images/${img.id}` })));
// }

function upload(formData) {
    
    console.log('upload is called......')

    const headers = new Headers();
    headers.append('Accept','application/json');

    const url = `${BASE_URL}`;
    return axiosInstance.post(url, formData,{headers:headers})
        // get data
        .then(x => x.data)
        // add url field
        .then(x => x.map(img => Object.assign({},
            img, { url: `${BASE_URL}/images/${img.id}` })));
}

function loadListOfImages(productId,type){
    const url = `/storage/list`;
    //const url = `/images/product/list`;
    return axiosInstance.get(url,{
        params:{
            productId: productId,
            type:type
        }
    })
        .then(x => x.data);
}

export { upload,loadListOfImages }