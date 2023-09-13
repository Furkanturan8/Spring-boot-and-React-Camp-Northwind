import React, { useState,useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { Button, Card, Image } from 'semantic-ui-react'
import ProductService from '../services/productService'

export default function ProductDetail() {
    let { name } = useParams() // Parametreleri obje olarak veriyor // destract ettik
   
    const [product, setProduct] = useState({}) // soldaki yapı neydi: destructor işlemi sağda ise fonx içi bir obje almış demekki useState bize bir nesne döndürüyor, biri data(product) bir de fonx(setProduct) döndürüyor   

    useEffect(()=>{
        // component yüklendiğinde bunu çalıştırır.
        let productService = new ProductService()
        productService.getByProductName(name).then(result=>setProduct(result.data.data))
    },[]) // virgülden sonra gelen boş dizi: sürekli eleman değiştiğinde sonsuz kere apiye istek göndermesin diye kullandık


    return (
        <div>
            <Card.Group>
                <Card fluid>
                    <Card.Content>
                        <Image
                            floated='right'
                            size='mini'
                            src='/images/avatar/large/jenny.jpg'
                        />
                        <Card.Header> {product.productName} </Card.Header>
                        <Card.Meta> {product.category !== undefined && product.category.categoryName} </Card.Meta>
                        <Card.Description>
                            Jenny requested permission to view your contact details
                        </Card.Description>
                    </Card.Content>
                    <Card.Content extra>
                        <div className='ui two buttons'>
                            <Button basic color='green'>
                                Approve
                            </Button>
                            <Button basic color='red'>
                                Decline
                            </Button>
                        </div>
                    </Card.Content>
                </Card>
            </Card.Group>

        </div>
    )
}
