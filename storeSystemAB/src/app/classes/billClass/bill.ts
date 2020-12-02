export class Bill {

    'billType': {
        decription: string,
        id: number,
    };

    'odeGeneration': string;
    'createdDate': Date;
    'id': number
    'incomingCompany': {
        address: string,
        decription: string,
        id: number
        phone: number
    };

    'project': null;
    'store': {
        decription: string,
        id: number,
        location: string
    };

    'user': {
        'id': number;
        'role':
        {
            'id': number,
            'decription': string
        },
        'userName': string
    }
}
