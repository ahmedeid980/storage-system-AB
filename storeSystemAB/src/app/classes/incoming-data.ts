export class IncomingData {

    'stores': {
        id: number;
        decription: string;
        location: string;
    };
    'categories': [
        {
            id: number;
            decription: string;
            'storeType':{
                decription: string;
                id: number;
                location: string
            }
            'unit':{
                decription: String;
                id: number;
            }
        }
    ];
    'incomingCompanise': [
        {
            address: string;
            decription: string;
            id: number;
            phone: number;
        }
    ]
}
