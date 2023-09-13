import React from 'react'
import {Formik,Form, Field, ErrorMessage} from 'formik'
import * as Yup from 'yup'
import { Button, FormField, Label } from 'semantic-ui-react'
import KodlamaIoTextInput from '../utilities/customFormControls/KodlamaIoTextInput'

export default function ProductAdd() {
 
    const initialValues = {productName:"", unitPrice:10}
    const schema = Yup.object({
        productName : Yup.string().required("Ürün adı zorunlu"),
        unitPrice : Yup.number().required("Ürün fiyatı zorunlu")
    })

    return (
    
        <Formik
            initialValues = {initialValues} // başlangıç degeri
            validationSchema = {schema} // doğrulama şeması
            onSubmit={(values)=>{

                console.log(values)
            }} // submit old. bu fonx çalışsın der, values asagidaki ürünadı ve fiyatıdır
        >
            <Form className='ui form'>
                <KodlamaIoTextInput name='productName' placeholder='Ürün Adı' />
                <KodlamaIoTextInput name='unitPrice' placeholder='Ürün Fiyatı' />
                <Button color='green' type='submit'> Ekle</Button>
            </Form>    
        </Formik>
    
  )
}

// redux-thunk nedir araştır?